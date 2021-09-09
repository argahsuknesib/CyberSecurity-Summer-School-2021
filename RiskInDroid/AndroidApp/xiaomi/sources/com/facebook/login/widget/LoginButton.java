package com.facebook.login.widget;

import _m_j.OO0000o;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.AccessToken;
import com.facebook.AccessTokenTracker;
import com.facebook.CallbackManager;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.Profile;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.internal.CallbackManagerImpl;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.Utility;
import com.facebook.login.DefaultAudience;
import com.facebook.login.LoginBehavior;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.ToolTipPopup;
import com.xiaomi.smarthome.R;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LoginButton extends FacebookButtonBase {
    private static final String TAG = "com.facebook.login.widget.LoginButton";
    private AccessTokenTracker accessTokenTracker;
    public boolean confirmLogout;
    public String loginLogoutEventName = "fb_login_view_usage";
    private LoginManager loginManager;
    private String loginText;
    private String logoutText;
    public LoginButtonProperties properties = new LoginButtonProperties();
    private boolean toolTipChecked;
    private long toolTipDisplayTime = 6000;
    private ToolTipMode toolTipMode;
    private ToolTipPopup toolTipPopup;
    private ToolTipPopup.Style toolTipStyle = ToolTipPopup.Style.BLUE;

    public int getDefaultStyleResource() {
        return R.style.com_facebook_loginview_default_style;
    }

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class ToolTipMode extends Enum<ToolTipMode> {
        private static final /* synthetic */ ToolTipMode[] $VALUES;
        public static final ToolTipMode AUTOMATIC = new ToolTipMode("AUTOMATIC", 0, "automatic", 0);
        public static ToolTipMode DEFAULT;
        public static final ToolTipMode DISPLAY_ALWAYS = new ToolTipMode("DISPLAY_ALWAYS", 1, "display_always", 1);
        public static final ToolTipMode NEVER_DISPLAY = new ToolTipMode("NEVER_DISPLAY", 2, "never_display", 2);
        private int intValue;
        private String stringValue;

        public static ToolTipMode valueOf(String str) {
            return (ToolTipMode) Enum.valueOf(ToolTipMode.class, str);
        }

        public static ToolTipMode[] values() {
            return (ToolTipMode[]) $VALUES.clone();
        }

        static {
            ToolTipMode toolTipMode = AUTOMATIC;
            $VALUES = new ToolTipMode[]{toolTipMode, DISPLAY_ALWAYS, NEVER_DISPLAY};
            DEFAULT = toolTipMode;
        }

        public static ToolTipMode fromInt(int i) {
            for (ToolTipMode toolTipMode : values()) {
                if (toolTipMode.getValue() == i) {
                    return toolTipMode;
                }
            }
            return null;
        }

        private ToolTipMode(String str, int i, String str2, int i2) {
            this.stringValue = str2;
            this.intValue = i2;
        }

        public final String toString() {
            return this.stringValue;
        }

        public final int getValue() {
            return this.intValue;
        }
    }

    static class LoginButtonProperties {
        private String authType = "rerequest";
        private DefaultAudience defaultAudience = DefaultAudience.FRIENDS;
        private LoginBehavior loginBehavior = LoginBehavior.NATIVE_WITH_FALLBACK;
        public List<String> permissions = Collections.emptyList();

        LoginButtonProperties() {
        }

        public void setDefaultAudience(DefaultAudience defaultAudience2) {
            this.defaultAudience = defaultAudience2;
        }

        public DefaultAudience getDefaultAudience() {
            return this.defaultAudience;
        }

        public void setPermissions(List<String> list) {
            this.permissions = list;
        }

        /* access modifiers changed from: package-private */
        public List<String> getPermissions() {
            return this.permissions;
        }

        public void clearPermissions() {
            this.permissions = null;
        }

        public void setLoginBehavior(LoginBehavior loginBehavior2) {
            this.loginBehavior = loginBehavior2;
        }

        public LoginBehavior getLoginBehavior() {
            return this.loginBehavior;
        }

        public String getAuthType() {
            return this.authType;
        }

        public void setAuthType(String str) {
            this.authType = str;
        }
    }

    public LoginButton(Context context) {
        super(context, null, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public LoginButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i, 0, "fb_login_button_create", "fb_login_button_did_tap");
    }

    public void setLoginText(String str) {
        this.loginText = str;
        setButtonText();
    }

    public void setLogoutText(String str) {
        this.logoutText = str;
        setButtonText();
    }

    public void setDefaultAudience(DefaultAudience defaultAudience) {
        this.properties.setDefaultAudience(defaultAudience);
    }

    public DefaultAudience getDefaultAudience() {
        return this.properties.getDefaultAudience();
    }

    public void setReadPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setReadPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void setPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void setPublishPermissions(List<String> list) {
        this.properties.setPermissions(list);
    }

    public void setPublishPermissions(String... strArr) {
        this.properties.setPermissions(Arrays.asList(strArr));
    }

    public void clearPermissions() {
        this.properties.clearPermissions();
    }

    public void setLoginBehavior(LoginBehavior loginBehavior) {
        this.properties.setLoginBehavior(loginBehavior);
    }

    public LoginBehavior getLoginBehavior() {
        return this.properties.getLoginBehavior();
    }

    public String getAuthType() {
        return this.properties.getAuthType();
    }

    public void setAuthType(String str) {
        this.properties.setAuthType(str);
    }

    public void setToolTipStyle(ToolTipPopup.Style style) {
        this.toolTipStyle = style;
    }

    public void setToolTipMode(ToolTipMode toolTipMode2) {
        this.toolTipMode = toolTipMode2;
    }

    public ToolTipMode getToolTipMode() {
        return this.toolTipMode;
    }

    public void setToolTipDisplayTime(long j) {
        this.toolTipDisplayTime = j;
    }

    public long getToolTipDisplayTime() {
        return this.toolTipDisplayTime;
    }

    public void dismissToolTip() {
        ToolTipPopup toolTipPopup2 = this.toolTipPopup;
        if (toolTipPopup2 != null) {
            toolTipPopup2.dismiss();
            this.toolTipPopup = null;
        }
    }

    public void registerCallback(CallbackManager callbackManager, FacebookCallback<LoginResult> facebookCallback) {
        getLoginManager().registerCallback(callbackManager, facebookCallback);
    }

    public void unregisterCallback(CallbackManager callbackManager) {
        getLoginManager().unregisterCallback(callbackManager);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
        if (accessTokenTracker2 != null && !accessTokenTracker2.isTracking()) {
            this.accessTokenTracker.startTracking();
            setButtonText();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.toolTipChecked && !isInEditMode()) {
            this.toolTipChecked = true;
            checkToolTipSettings();
        }
    }

    public void showToolTipPerSettings(FetchedAppSettings fetchedAppSettings) {
        if (fetchedAppSettings != null && fetchedAppSettings.getNuxEnabled() && getVisibility() == 0) {
            displayToolTip(fetchedAppSettings.getNuxContent());
        }
    }

    private void displayToolTip(String str) {
        this.toolTipPopup = new ToolTipPopup(str, this);
        this.toolTipPopup.setStyle(this.toolTipStyle);
        this.toolTipPopup.setNuxDisplayTime(this.toolTipDisplayTime);
        this.toolTipPopup.show();
    }

    /* renamed from: com.facebook.login.widget.LoginButton$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode = new int[ToolTipMode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.AUTOMATIC.ordinal()] = 1;
            $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.DISPLAY_ALWAYS.ordinal()] = 2;
            try {
                $SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[ToolTipMode.NEVER_DISPLAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    private void checkToolTipSettings() {
        int i = AnonymousClass3.$SwitchMap$com$facebook$login$widget$LoginButton$ToolTipMode[this.toolTipMode.ordinal()];
        if (i == 1) {
            final String metadataApplicationId = Utility.getMetadataApplicationId(getContext());
            FacebookSdk.getExecutor().execute(new Runnable() {
                /* class com.facebook.login.widget.LoginButton.AnonymousClass1 */

                public void run() {
                    final FetchedAppSettings queryAppSettings = FetchedAppSettingsManager.queryAppSettings(metadataApplicationId, false);
                    LoginButton.this.getActivity().runOnUiThread(new Runnable() {
                        /* class com.facebook.login.widget.LoginButton.AnonymousClass1.AnonymousClass1 */

                        public void run() {
                            LoginButton.this.showToolTipPerSettings(queryAppSettings);
                        }
                    });
                }
            });
        } else if (i == 2) {
            displayToolTip(getResources().getString(R.string.com_facebook_tooltip_default));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setButtonText();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AccessTokenTracker accessTokenTracker2 = this.accessTokenTracker;
        if (accessTokenTracker2 != null) {
            accessTokenTracker2.stopTracking();
        }
        dismissToolTip();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            dismissToolTip();
        }
    }

    /* access modifiers changed from: package-private */
    public List<String> getPermissions() {
        return this.properties.getPermissions();
    }

    /* access modifiers changed from: package-private */
    public void setProperties(LoginButtonProperties loginButtonProperties) {
        this.properties = loginButtonProperties;
    }

    public void configureButton(Context context, AttributeSet attributeSet, int i, int i2) {
        super.configureButton(context, attributeSet, i, i2);
        setInternalOnClickListener(getNewLoginClickListener());
        parseLoginButtonAttributes(context, attributeSet, i, i2);
        if (isInEditMode()) {
            setBackgroundColor(getResources().getColor(R.color.com_facebook_blue));
            this.loginText = "Continue with Facebook";
        } else {
            this.accessTokenTracker = new AccessTokenTracker() {
                /* class com.facebook.login.widget.LoginButton.AnonymousClass2 */

                public void onCurrentAccessTokenChanged(AccessToken accessToken, AccessToken accessToken2) {
                    LoginButton.this.setButtonText();
                }
            };
        }
        setButtonText();
        setCompoundDrawablesWithIntrinsicBounds(OO0000o.O00000Oo(getContext(), R.drawable.com_facebook_button_icon), (Drawable) null, (Drawable) null, (Drawable) null);
    }

    /* access modifiers changed from: protected */
    public LoginClickListener getNewLoginClickListener() {
        return new LoginClickListener();
    }

    private void parseLoginButtonAttributes(Context context, AttributeSet attributeSet, int i, int i2) {
        this.toolTipMode = ToolTipMode.DEFAULT;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, new int[]{R.attr.com_facebook_confirm_logout, R.attr.com_facebook_login_text, R.attr.com_facebook_logout_text, R.attr.com_facebook_tooltip_mode}, i, i2);
        try {
            this.confirmLogout = obtainStyledAttributes.getBoolean(0, true);
            this.loginText = obtainStyledAttributes.getString(1);
            this.logoutText = obtainStyledAttributes.getString(2);
            this.toolTipMode = ToolTipMode.fromInt(obtainStyledAttributes.getInt(3, ToolTipMode.DEFAULT.getValue()));
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        Paint.FontMetrics fontMetrics = getPaint().getFontMetrics();
        int compoundPaddingTop = getCompoundPaddingTop() + ((int) Math.ceil((double) (Math.abs(fontMetrics.top) + Math.abs(fontMetrics.bottom)))) + getCompoundPaddingBottom();
        Resources resources = getResources();
        String str = this.loginText;
        if (str == null) {
            str = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
            int measureButtonWidth = measureButtonWidth(str);
            if (resolveSize(measureButtonWidth, i) < measureButtonWidth) {
                str = resources.getString(R.string.com_facebook_loginview_log_in_button);
            }
        }
        int measureButtonWidth2 = measureButtonWidth(str);
        String str2 = this.logoutText;
        if (str2 == null) {
            str2 = resources.getString(R.string.com_facebook_loginview_log_out_button);
        }
        setMeasuredDimension(resolveSize(Math.max(measureButtonWidth2, measureButtonWidth(str2)), i), compoundPaddingTop);
    }

    private int measureButtonWidth(String str) {
        return getCompoundPaddingLeft() + getCompoundDrawablePadding() + measureTextWidth(str) + getCompoundPaddingRight();
    }

    public void setButtonText() {
        Resources resources = getResources();
        if (isInEditMode() || !AccessToken.isCurrentAccessTokenActive()) {
            String str = this.loginText;
            if (str != null) {
                setText(str);
                return;
            }
            String string = resources.getString(R.string.com_facebook_loginview_log_in_button_continue);
            int width = getWidth();
            if (width != 0 && measureButtonWidth(string) > width) {
                string = resources.getString(R.string.com_facebook_loginview_log_in_button);
            }
            setText(string);
            return;
        }
        String str2 = this.logoutText;
        if (str2 == null) {
            str2 = resources.getString(R.string.com_facebook_loginview_log_out_button);
        }
        setText(str2);
    }

    public int getDefaultRequestCode() {
        return CallbackManagerImpl.RequestCodeOffset.Login.toRequestCode();
    }

    /* access modifiers changed from: package-private */
    public LoginManager getLoginManager() {
        if (this.loginManager == null) {
            this.loginManager = LoginManager.getInstance();
        }
        return this.loginManager;
    }

    /* access modifiers changed from: package-private */
    public void setLoginManager(LoginManager loginManager2) {
        this.loginManager = loginManager2;
    }

    public class LoginClickListener implements View.OnClickListener {
        protected LoginClickListener() {
        }

        public void onClick(View view) {
            LoginButton.this.callExternalOnClickListener(view);
            AccessToken currentAccessToken = AccessToken.getCurrentAccessToken();
            if (AccessToken.isCurrentAccessTokenActive()) {
                performLogout(LoginButton.this.getContext());
            } else {
                performLogin();
            }
            InternalAppEventsLogger internalAppEventsLogger = new InternalAppEventsLogger(LoginButton.this.getContext());
            Bundle bundle = new Bundle();
            bundle.putInt("logging_in", currentAccessToken != null ? 0 : 1);
            bundle.putInt("access_token_expired", AccessToken.isCurrentAccessTokenActive() ? 1 : 0);
            internalAppEventsLogger.logEventImplicitly(LoginButton.this.loginLogoutEventName, bundle);
        }

        /* access modifiers changed from: protected */
        public void performLogin() {
            LoginManager loginManager = getLoginManager();
            if (LoginButton.this.getFragment() != null) {
                loginManager.logIn(LoginButton.this.getFragment(), LoginButton.this.properties.permissions);
            } else if (LoginButton.this.getNativeFragment() != null) {
                loginManager.logIn(LoginButton.this.getNativeFragment(), LoginButton.this.properties.permissions);
            } else {
                loginManager.logIn(LoginButton.this.getActivity(), LoginButton.this.properties.permissions);
            }
        }

        /* access modifiers changed from: protected */
        public void performLogout(Context context) {
            String str;
            final LoginManager loginManager = getLoginManager();
            if (LoginButton.this.confirmLogout) {
                String string = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_log_out_action);
                String string2 = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_cancel_action);
                Profile currentProfile = Profile.getCurrentProfile();
                if (currentProfile == null || currentProfile.getName() == null) {
                    str = LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_using_facebook);
                } else {
                    str = String.format(LoginButton.this.getResources().getString(R.string.com_facebook_loginview_logged_in_as), currentProfile.getName());
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage(str).setCancelable(true).setPositiveButton(string, new DialogInterface.OnClickListener() {
                    /* class com.facebook.login.widget.LoginButton.LoginClickListener.AnonymousClass1 */

                    public void onClick(DialogInterface dialogInterface, int i) {
                        loginManager.logOut();
                    }
                }).setNegativeButton(string2, (DialogInterface.OnClickListener) null);
                builder.create().show();
                return;
            }
            loginManager.logOut();
        }

        /* access modifiers changed from: protected */
        public LoginManager getLoginManager() {
            LoginManager instance = LoginManager.getInstance();
            instance.setDefaultAudience(LoginButton.this.getDefaultAudience());
            instance.setLoginBehavior(LoginButton.this.getLoginBehavior());
            instance.setAuthType(LoginButton.this.getAuthType());
            return instance;
        }
    }
}
