package com.facebook.internal;

import _m_j.dz;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog;

public class FacebookDialogFragment extends dz {
    private Dialog dialog;

    public void setDialog(Dialog dialog2) {
        this.dialog = dialog2;
    }

    public void onCreate(Bundle bundle) {
        WebDialog webDialog;
        super.onCreate(bundle);
        if (this.dialog == null) {
            FragmentActivity activity = getActivity();
            Bundle methodArgumentsFromIntent = NativeProtocol.getMethodArgumentsFromIntent(activity.getIntent());
            if (!methodArgumentsFromIntent.getBoolean("is_fallback", false)) {
                String string = methodArgumentsFromIntent.getString("action");
                Bundle bundle2 = methodArgumentsFromIntent.getBundle("params");
                if (Utility.isNullOrEmpty(string)) {
                    Utility.logd("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    activity.finish();
                    return;
                }
                webDialog = new WebDialog.Builder(activity, string, bundle2).setOnCompleteListener(new WebDialog.OnCompleteListener() {
                    /* class com.facebook.internal.FacebookDialogFragment.AnonymousClass1 */

                    public void onComplete(Bundle bundle, FacebookException facebookException) {
                        FacebookDialogFragment.this.onCompleteWebDialog(bundle, facebookException);
                    }
                }).build();
            } else {
                String string2 = methodArgumentsFromIntent.getString("url");
                if (Utility.isNullOrEmpty(string2)) {
                    Utility.logd("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    activity.finish();
                    return;
                }
                webDialog = FacebookWebFallbackDialog.newInstance(activity, string2, String.format("fb%s://bridge/", FacebookSdk.getApplicationId()));
                webDialog.setOnCompleteListener(new WebDialog.OnCompleteListener() {
                    /* class com.facebook.internal.FacebookDialogFragment.AnonymousClass2 */

                    public void onComplete(Bundle bundle, FacebookException facebookException) {
                        FacebookDialogFragment.this.onCompleteWebFallbackDialog(bundle);
                    }
                });
            }
            this.dialog = webDialog;
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        if (this.dialog == null) {
            onCompleteWebDialog(null, null);
            setShowsDialog(false);
        }
        return this.dialog;
    }

    public void onResume() {
        super.onResume();
        Dialog dialog2 = this.dialog;
        if (dialog2 instanceof WebDialog) {
            ((WebDialog) dialog2).resize();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if ((this.dialog instanceof WebDialog) && isResumed()) {
            ((WebDialog) this.dialog).resize();
        }
    }

    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance()) {
            getDialog().setDismissMessage(null);
        }
        super.onDestroyView();
    }

    public void onCompleteWebDialog(Bundle bundle, FacebookException facebookException) {
        FragmentActivity activity = getActivity();
        activity.setResult(facebookException == null ? -1 : 0, NativeProtocol.createProtocolResultIntent(activity.getIntent(), bundle, facebookException));
        activity.finish();
    }

    public void onCompleteWebFallbackDialog(Bundle bundle) {
        FragmentActivity activity = getActivity();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        activity.setResult(-1, intent);
        activity.finish();
    }
}
