package com.facebook.login;

import _m_j.dz;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.facebook.AccessToken;
import com.facebook.AccessTokenSource;
import com.facebook.FacebookActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookRequestError;
import com.facebook.FacebookSdk;
import com.facebook.GraphRequest;
import com.facebook.GraphRequestAsyncTask;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.appevents.InternalAppEventsLogger;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.SmartLoginOption;
import com.facebook.internal.Utility;
import com.facebook.internal.Validate;
import com.facebook.login.LoginClient;
import com.xiaomi.smarthome.R;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceAuthDialog extends dz {
    public AtomicBoolean completed = new AtomicBoolean();
    private TextView confirmationCode;
    private volatile GraphRequestAsyncTask currentGraphRequestPoll;
    public volatile RequestState currentRequestState;
    private DeviceAuthMethodHandler deviceAuthMethodHandler;
    public Dialog dialog;
    private TextView instructions;
    public boolean isBeingDestroyed = false;
    public boolean isRetry = false;
    public LoginClient.Request mRequest = null;
    private View progressBar;
    private volatile ScheduledFuture scheduledPoll;

    /* access modifiers changed from: protected */
    public int getLayoutResId(boolean z) {
        return z ? R.layout.com_facebook_smart_device_dialog_fragment : R.layout.com_facebook_device_auth_dialog_fragment;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        this.deviceAuthMethodHandler = (DeviceAuthMethodHandler) ((LoginFragment) ((FacebookActivity) getActivity()).getCurrentFragment()).getLoginClient().getCurrentHandler();
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable("request_state")) == null)) {
            setCurrentRequestState(requestState);
        }
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.dialog = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
        this.dialog.setContentView(initializeContentView(DeviceRequestsHelper.isAvailable() && !this.isRetry));
        return this.dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (!this.isBeingDestroyed) {
            onCancel();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable("request_state", this.currentRequestState);
        }
    }

    public void onDestroy() {
        this.isBeingDestroyed = true;
        this.completed.set(true);
        super.onDestroy();
        if (this.currentGraphRequestPoll != null) {
            this.currentGraphRequestPoll.cancel(true);
        }
        if (this.scheduledPoll != null) {
            this.scheduledPoll.cancel(true);
        }
    }

    public void startLogin(LoginClient.Request request) {
        this.mRequest = request;
        Bundle bundle = new Bundle();
        bundle.putString("scope", TextUtils.join(",", request.getPermissions()));
        String deviceRedirectUriString = request.getDeviceRedirectUriString();
        if (deviceRedirectUriString != null) {
            bundle.putString("redirect_uri", deviceRedirectUriString);
        }
        String deviceAuthTargetUserId = request.getDeviceAuthTargetUserId();
        if (deviceAuthTargetUserId != null) {
            bundle.putString("target_user_id", deviceAuthTargetUserId);
        }
        bundle.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        bundle.putString("device_info", DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, "device/login", bundle, HttpMethod.POST, new GraphRequest.Callback() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass1 */

            public void onCompleted(GraphResponse graphResponse) {
                if (!DeviceAuthDialog.this.isBeingDestroyed) {
                    if (graphResponse.getError() != null) {
                        DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                        return;
                    }
                    JSONObject jSONObject = graphResponse.getJSONObject();
                    RequestState requestState = new RequestState();
                    try {
                        requestState.setUserCode(jSONObject.getString("user_code"));
                        requestState.setRequestCode(jSONObject.getString("code"));
                        requestState.setInterval(jSONObject.getLong("interval"));
                        DeviceAuthDialog.this.setCurrentRequestState(requestState);
                    } catch (JSONException e) {
                        DeviceAuthDialog.this.onError(new FacebookException(e));
                    }
                }
            }
        }).executeAsync();
    }

    public void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.instructions.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, new BitmapDrawable(getResources(), DeviceRequestsHelper.generateQRCode(requestState.getAuthorizationUri())), (Drawable) null, (Drawable) null);
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        if (!this.isRetry && DeviceRequestsHelper.startAdvertisementService(requestState.getUserCode())) {
            new InternalAppEventsLogger(getContext()).logEventImplicitly("fb_smart_login_service");
        }
        if (requestState.withinLastRefreshWindow()) {
            schedulePoll();
        } else {
            poll();
        }
    }

    /* access modifiers changed from: protected */
    public View initializeContentView(boolean z) {
        View inflate = getActivity().getLayoutInflater().inflate(getLayoutResId(z), (ViewGroup) null);
        this.progressBar = inflate.findViewById(R.id.progress_bar);
        this.confirmationCode = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass2 */

            public void onClick(View view) {
                DeviceAuthDialog.this.onCancel();
            }
        });
        this.instructions = (TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions);
        this.instructions.setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        return inflate;
    }

    public void poll() {
        this.currentRequestState.setLastPoll(new Date().getTime());
        this.currentGraphRequestPoll = getPollRequest().executeAsync();
    }

    public void schedulePoll() {
        this.scheduledPoll = DeviceAuthMethodHandler.getBackgroundExecutor().schedule(new Runnable() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass3 */

            public void run() {
                DeviceAuthDialog.this.poll();
            }
        }, this.currentRequestState.getInterval(), TimeUnit.SECONDS);
    }

    private GraphRequest getPollRequest() {
        Bundle bundle = new Bundle();
        bundle.putString("code", this.currentRequestState.getRequestCode());
        return new GraphRequest(null, "device/login_status", bundle, HttpMethod.POST, new GraphRequest.Callback() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass4 */

            public void onCompleted(GraphResponse graphResponse) {
                if (!DeviceAuthDialog.this.completed.get()) {
                    FacebookRequestError error = graphResponse.getError();
                    if (error != null) {
                        int subErrorCode = error.getSubErrorCode();
                        if (subErrorCode != 1349152) {
                            switch (subErrorCode) {
                                case 1349172:
                                case 1349174:
                                    DeviceAuthDialog.this.schedulePoll();
                                    return;
                                case 1349173:
                                    DeviceAuthDialog.this.onCancel();
                                    return;
                                default:
                                    DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                                    return;
                            }
                        } else {
                            if (DeviceAuthDialog.this.currentRequestState != null) {
                                DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                            }
                            if (DeviceAuthDialog.this.mRequest != null) {
                                DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                                deviceAuthDialog.startLogin(deviceAuthDialog.mRequest);
                                return;
                            }
                            DeviceAuthDialog.this.onCancel();
                        }
                    } else {
                        try {
                            JSONObject jSONObject = graphResponse.getJSONObject();
                            DeviceAuthDialog.this.onSuccess(jSONObject.getString("access_token"), Long.valueOf(jSONObject.getLong("expires_in")), Long.valueOf(jSONObject.optLong("data_access_expiration_time")));
                        } catch (JSONException e) {
                            DeviceAuthDialog.this.onError(new FacebookException(e));
                        }
                    }
                }
            }
        });
    }

    public void presentConfirmation(String str, Utility.PermissionsLists permissionsLists, String str2, String str3, Date date, Date date2) {
        String string = getResources().getString(R.string.com_facebook_smart_login_confirmation_title);
        String string2 = getResources().getString(R.string.com_facebook_smart_login_confirmation_continue_as);
        String string3 = getResources().getString(R.string.com_facebook_smart_login_confirmation_cancel);
        String format = String.format(string2, str3);
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        final String str4 = str;
        final Utility.PermissionsLists permissionsLists2 = permissionsLists;
        final String str5 = str2;
        final Date date3 = date;
        final Date date4 = date2;
        builder.setMessage(string).setCancelable(true).setNegativeButton(format, new DialogInterface.OnClickListener() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass6 */

            public void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.this.completeLogin(str4, permissionsLists2, str5, date3, date4);
            }
        }).setPositiveButton(string3, new DialogInterface.OnClickListener() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass5 */

            public void onClick(DialogInterface dialogInterface, int i) {
                DeviceAuthDialog.this.dialog.setContentView(DeviceAuthDialog.this.initializeContentView(false));
                DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                deviceAuthDialog.startLogin(deviceAuthDialog.mRequest);
            }
        });
        builder.create().show();
    }

    public void onSuccess(String str, Long l, Long l2) {
        Bundle bundle = new Bundle();
        bundle.putString("fields", "id,permissions,name");
        final Date date = null;
        final Date date2 = l.longValue() != 0 ? new Date(new Date().getTime() + (l.longValue() * 1000)) : null;
        if (!(l2.longValue() == 0 || l2 == null)) {
            date = new Date(l2.longValue() * 1000);
        }
        final String str2 = str;
        new GraphRequest(new AccessToken(str, FacebookSdk.getApplicationId(), "0", null, null, null, null, date2, null, date), "me", bundle, HttpMethod.GET, new GraphRequest.Callback() {
            /* class com.facebook.login.DeviceAuthDialog.AnonymousClass7 */

            public void onCompleted(GraphResponse graphResponse) {
                if (!DeviceAuthDialog.this.completed.get()) {
                    if (graphResponse.getError() != null) {
                        DeviceAuthDialog.this.onError(graphResponse.getError().getException());
                        return;
                    }
                    try {
                        JSONObject jSONObject = graphResponse.getJSONObject();
                        String string = jSONObject.getString("id");
                        Utility.PermissionsLists handlePermissionResponse = Utility.handlePermissionResponse(jSONObject);
                        String string2 = jSONObject.getString("name");
                        DeviceRequestsHelper.cleanUpAdvertisementService(DeviceAuthDialog.this.currentRequestState.getUserCode());
                        if (!FetchedAppSettingsManager.getAppSettingsWithoutQuery(FacebookSdk.getApplicationId()).getSmartLoginOptions().contains(SmartLoginOption.RequireConfirm) || DeviceAuthDialog.this.isRetry) {
                            DeviceAuthDialog.this.completeLogin(string, handlePermissionResponse, str2, date2, date);
                            return;
                        }
                        DeviceAuthDialog deviceAuthDialog = DeviceAuthDialog.this;
                        deviceAuthDialog.isRetry = true;
                        deviceAuthDialog.presentConfirmation(string, handlePermissionResponse, str2, string2, date2, date);
                    } catch (JSONException e) {
                        DeviceAuthDialog.this.onError(new FacebookException(e));
                    }
                }
            }
        }).executeAsync();
    }

    public void completeLogin(String str, Utility.PermissionsLists permissionsLists, String str2, Date date, Date date2) {
        this.deviceAuthMethodHandler.onSuccess(str2, FacebookSdk.getApplicationId(), str, permissionsLists.getGrantedPermissions(), permissionsLists.getDeclinedPermissions(), permissionsLists.getExpiredPermissions(), AccessTokenSource.DEVICE_AUTH, date, null, date2);
        this.dialog.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onError(FacebookException facebookException) {
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
            }
            this.deviceAuthMethodHandler.onError(facebookException);
            this.dialog.dismiss();
        }
    }

    /* access modifiers changed from: protected */
    public void onCancel() {
        if (this.completed.compareAndSet(false, true)) {
            if (this.currentRequestState != null) {
                DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
            }
            DeviceAuthMethodHandler deviceAuthMethodHandler2 = this.deviceAuthMethodHandler;
            if (deviceAuthMethodHandler2 != null) {
                deviceAuthMethodHandler2.onCancel();
            }
            this.dialog.dismiss();
        }
    }

    static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() {
            /* class com.facebook.login.DeviceAuthDialog.RequestState.AnonymousClass1 */

            public final RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            public final RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        };
        private String authorizationUri;
        private long interval;
        private long lastPoll;
        private String requestCode;
        private String userCode;

        public int describeContents() {
            return 0;
        }

        RequestState() {
        }

        public String getAuthorizationUri() {
            return this.authorizationUri;
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setUserCode(String str) {
            this.userCode = str;
            this.authorizationUri = String.format(Locale.ENGLISH, "https://facebook.com/device?user_code=%1$s&qr=1", str);
        }

        public String getRequestCode() {
            return this.requestCode;
        }

        public void setRequestCode(String str) {
            this.requestCode = str;
        }

        public long getInterval() {
            return this.interval;
        }

        public void setInterval(long j) {
            this.interval = j;
        }

        public void setLastPoll(long j) {
            this.lastPoll = j;
        }

        protected RequestState(Parcel parcel) {
            this.authorizationUri = parcel.readString();
            this.userCode = parcel.readString();
            this.requestCode = parcel.readString();
            this.interval = parcel.readLong();
            this.lastPoll = parcel.readLong();
        }

        public boolean withinLastRefreshWindow() {
            if (this.lastPoll != 0 && (new Date().getTime() - this.lastPoll) - (this.interval * 1000) < 0) {
                return true;
            }
            return false;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.authorizationUri);
            parcel.writeString(this.userCode);
            parcel.writeString(this.requestCode);
            parcel.writeLong(this.interval);
            parcel.writeLong(this.lastPoll);
        }
    }
}
