package _m_j;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.model.ShareVideo;
import com.facebook.share.model.ShareVideoContent;
import com.facebook.share.widget.ShareDialog;
import com.sankuai.waimai.router.annotation.RouterService;
import com.xiaomi.smarthome.application.CommonApplication;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

@RouterService
public class frq implements frp {
    private static AtomicBoolean sIsFacebookSdkInited = new AtomicBoolean(false);
    public CallbackManager mFBCallbackManager;
    public LoginManager mFacebookLoginManager;

    public void initFacebookSdk(boolean z) {
        if (CommonApplication.shouldInitFacebookSdk() && !sIsFacebookSdkInited.getAndSet(true)) {
            FacebookSdk.sdkInitialize(CommonApplication.getAppContext());
            if (z) {
                FacebookSdk.setIsDebugEnabled(true);
                FacebookSdk.addLoggingBehavior(LoggingBehavior.GRAPH_API_DEBUG_INFO);
                FacebookSdk.addLoggingBehavior(LoggingBehavior.DEVELOPER_ERRORS);
                FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_ACCESS_TOKENS);
                FacebookSdk.addLoggingBehavior(LoggingBehavior.INCLUDE_RAW_RESPONSES);
            }
            AppEventsLogger.activateApp(CommonApplication.getAppContext());
        }
    }

    public void shareFacebook(Activity activity, Bitmap bitmap, boolean z, String str, String str2) {
        if (bitmap != null) {
            new ShareDialog(activity).show(new SharePhotoContent.Builder().addPhoto(new SharePhoto.Builder().setBitmap(bitmap).build()).build(), ShareDialog.Mode.AUTOMATIC);
        } else if (z) {
            new ShareDialog(activity).show(new ShareVideoContent.Builder().setVideo(new ShareVideo.Builder().setLocalUrl(Uri.fromFile(new File(str))).build()).build(), ShareDialog.Mode.AUTOMATIC);
        } else if (str2 != null) {
            new ShareDialog(activity).show(new ShareLinkContent.Builder().readFrom(((ShareLinkContent.Builder) new ShareLinkContent.Builder().setContentUrl(Uri.parse(str2))).build()).build(), ShareDialog.Mode.AUTOMATIC);
        }
    }

    public void bindFb(Activity activity, final frn<String, String> frn) {
        if (this.mFacebookLoginManager == null) {
            this.mFacebookLoginManager = LoginManager.getInstance();
        }
        this.mFBCallbackManager = CallbackManager.Factory.create();
        this.mFacebookLoginManager.registerCallback(this.mFBCallbackManager, new FacebookCallback<LoginResult>() {
            /* class _m_j.frq.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                LoginResult loginResult = (LoginResult) obj;
                frn frn = frn;
                if (frn != null) {
                    frn.O000000o(loginResult.getAccessToken().getToken(), String.valueOf(loginResult.getAccessToken().getExpires().getTime()));
                }
                frq.this.mFacebookLoginManager.logOut();
                frq.this.mFacebookLoginManager.registerCallback(frq.this.mFBCallbackManager, null);
            }

            public final void onCancel() {
                frn frn = frn;
                if (frn != null) {
                    frn.O000000o();
                }
                frq.this.mFacebookLoginManager.registerCallback(frq.this.mFBCallbackManager, null);
            }

            public final void onError(FacebookException facebookException) {
                frq.this.mFacebookLoginManager.registerCallback(frq.this.mFBCallbackManager, null);
                frn frn = frn;
                if (frn != null) {
                    new Error(facebookException.getMessage());
                    frn.O00000Oo();
                }
            }
        });
        this.mFacebookLoginManager.logInWithReadPermissions(activity, Arrays.asList("public_profile"));
    }

    public void logOut() {
        LoginManager.getInstance().logOut();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        if (this.mFacebookLoginManager != null) {
            this.mFBCallbackManager.onActivityResult(i, i2, intent);
        }
    }
}
