package com.facebook.share.internal;

import _m_j.dz;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookRequestError;
import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.HttpMethod;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.Validate;
import com.facebook.share.model.ShareContent;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.ShareOpenGraphContent;
import com.xiaomi.smarthome.R;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class DeviceShareDialogFragment extends dz {
    private static ScheduledThreadPoolExecutor backgroundExecutor;
    private volatile ScheduledFuture codeExpiredFuture;
    private TextView confirmationCode;
    private volatile RequestState currentRequestState;
    public Dialog dialog;
    private ProgressBar progressBar;
    private ShareContent shareContent;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        RequestState requestState;
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!(bundle == null || (requestState = (RequestState) bundle.getParcelable("request_state")) == null)) {
            setCurrentRequestState(requestState);
        }
        return onCreateView;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        this.dialog = new Dialog(getActivity(), R.style.com_facebook_auth_dialog);
        View inflate = getActivity().getLayoutInflater().inflate((int) R.layout.com_facebook_device_auth_dialog_fragment, (ViewGroup) null);
        this.progressBar = (ProgressBar) inflate.findViewById(R.id.progress_bar);
        this.confirmationCode = (TextView) inflate.findViewById(R.id.confirmation_code);
        ((Button) inflate.findViewById(R.id.cancel_button)).setOnClickListener(new View.OnClickListener() {
            /* class com.facebook.share.internal.DeviceShareDialogFragment.AnonymousClass1 */

            public void onClick(View view) {
                DeviceShareDialogFragment.this.dialog.dismiss();
            }
        });
        ((TextView) inflate.findViewById(R.id.com_facebook_device_auth_instructions)).setText(Html.fromHtml(getString(R.string.com_facebook_device_auth_instructions)));
        this.dialog.setContentView(inflate);
        startShare();
        return this.dialog;
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (this.codeExpiredFuture != null) {
            this.codeExpiredFuture.cancel(true);
        }
        finishActivity(-1, new Intent());
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.currentRequestState != null) {
            bundle.putParcelable("request_state", this.currentRequestState);
        }
    }

    private void finishActivity(int i, Intent intent) {
        if (this.currentRequestState != null) {
            DeviceRequestsHelper.cleanUpAdvertisementService(this.currentRequestState.getUserCode());
        }
        FacebookRequestError facebookRequestError = (FacebookRequestError) intent.getParcelableExtra("error");
        if (facebookRequestError != null) {
            Toast.makeText(getContext(), facebookRequestError.getErrorMessage(), 0).show();
        }
        if (isAdded()) {
            FragmentActivity activity = getActivity();
            activity.setResult(i, intent);
            activity.finish();
        }
    }

    private void detach() {
        if (isAdded()) {
            getFragmentManager().O000000o().O000000o(this).O00000Oo();
        }
    }

    public void setShareContent(ShareContent shareContent2) {
        this.shareContent = shareContent2;
    }

    private Bundle getGraphParametersForShareContent() {
        ShareContent shareContent2 = this.shareContent;
        if (shareContent2 == null) {
            return null;
        }
        if (shareContent2 instanceof ShareLinkContent) {
            return WebDialogParameters.create((ShareLinkContent) shareContent2);
        }
        if (shareContent2 instanceof ShareOpenGraphContent) {
            return WebDialogParameters.create((ShareOpenGraphContent) shareContent2);
        }
        return null;
    }

    private void startShare() {
        Bundle graphParametersForShareContent = getGraphParametersForShareContent();
        if (graphParametersForShareContent == null || graphParametersForShareContent.size() == 0) {
            finishActivityWithError(new FacebookRequestError(0, "", "Failed to get share content"));
        }
        graphParametersForShareContent.putString("access_token", Validate.hasAppID() + "|" + Validate.hasClientToken());
        graphParametersForShareContent.putString("device_info", DeviceRequestsHelper.getDeviceInfo());
        new GraphRequest(null, "device/share", graphParametersForShareContent, HttpMethod.POST, new GraphRequest.Callback() {
            /* class com.facebook.share.internal.DeviceShareDialogFragment.AnonymousClass2 */

            public void onCompleted(GraphResponse graphResponse) {
                FacebookRequestError error = graphResponse.getError();
                if (error != null) {
                    DeviceShareDialogFragment.this.finishActivityWithError(error);
                    return;
                }
                JSONObject jSONObject = graphResponse.getJSONObject();
                RequestState requestState = new RequestState();
                try {
                    requestState.setUserCode(jSONObject.getString("user_code"));
                    requestState.setExpiresIn(jSONObject.getLong("expires_in"));
                    DeviceShareDialogFragment.this.setCurrentRequestState(requestState);
                } catch (JSONException unused) {
                    DeviceShareDialogFragment.this.finishActivityWithError(new FacebookRequestError(0, "", "Malformed server response"));
                }
            }
        }).executeAsync();
    }

    public void finishActivityWithError(FacebookRequestError facebookRequestError) {
        detach();
        Intent intent = new Intent();
        intent.putExtra("error", facebookRequestError);
        finishActivity(-1, intent);
    }

    private static synchronized ScheduledThreadPoolExecutor getBackgroundExecutor() {
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;
        synchronized (DeviceShareDialogFragment.class) {
            if (backgroundExecutor == null) {
                backgroundExecutor = new ScheduledThreadPoolExecutor(1);
            }
            scheduledThreadPoolExecutor = backgroundExecutor;
        }
        return scheduledThreadPoolExecutor;
    }

    public void setCurrentRequestState(RequestState requestState) {
        this.currentRequestState = requestState;
        this.confirmationCode.setText(requestState.getUserCode());
        this.confirmationCode.setVisibility(0);
        this.progressBar.setVisibility(8);
        this.codeExpiredFuture = getBackgroundExecutor().schedule(new Runnable() {
            /* class com.facebook.share.internal.DeviceShareDialogFragment.AnonymousClass3 */

            public void run() {
                DeviceShareDialogFragment.this.dialog.dismiss();
            }
        }, requestState.getExpiresIn(), TimeUnit.SECONDS);
    }

    static class RequestState implements Parcelable {
        public static final Parcelable.Creator<RequestState> CREATOR = new Parcelable.Creator<RequestState>() {
            /* class com.facebook.share.internal.DeviceShareDialogFragment.RequestState.AnonymousClass1 */

            public final RequestState createFromParcel(Parcel parcel) {
                return new RequestState(parcel);
            }

            public final RequestState[] newArray(int i) {
                return new RequestState[i];
            }
        };
        private long expiresIn;
        private String userCode;

        public int describeContents() {
            return 0;
        }

        RequestState() {
        }

        public String getUserCode() {
            return this.userCode;
        }

        public void setUserCode(String str) {
            this.userCode = str;
        }

        public long getExpiresIn() {
            return this.expiresIn;
        }

        public void setExpiresIn(long j) {
            this.expiresIn = j;
        }

        protected RequestState(Parcel parcel) {
            this.userCode = parcel.readString();
            this.expiresIn = parcel.readLong();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.userCode);
            parcel.writeLong(this.expiresIn);
        }
    }
}
