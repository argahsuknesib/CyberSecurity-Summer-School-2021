package com.facebook.login;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.facebook.login.LoginClient;
import com.xiaomi.smarthome.R;

public class LoginFragment extends Fragment {
    private String callingPackage;
    private LoginClient loginClient;
    private LoginClient.Request request;

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.com_facebook_login_fragment;
    }

    public void onCreate(Bundle bundle) {
        Bundle bundleExtra;
        super.onCreate(bundle);
        if (bundle != null) {
            this.loginClient = (LoginClient) bundle.getParcelable("loginClient");
            this.loginClient.setFragment(this);
        } else {
            this.loginClient = createLoginClient();
        }
        this.loginClient.setOnCompletedListener(new LoginClient.OnCompletedListener() {
            /* class com.facebook.login.LoginFragment.AnonymousClass1 */

            public void onCompleted(LoginClient.Result result) {
                LoginFragment.this.onLoginClientCompleted(result);
            }
        });
        FragmentActivity activity = getActivity();
        if (activity != null) {
            initializeCallingPackage(activity);
            Intent intent = activity.getIntent();
            if (intent != null && (bundleExtra = intent.getBundleExtra("com.facebook.LoginFragment:Request")) != null) {
                this.request = (LoginClient.Request) bundleExtra.getParcelable("request");
            }
        }
    }

    /* access modifiers changed from: protected */
    public LoginClient createLoginClient() {
        return new LoginClient(this);
    }

    public void onDestroy() {
        this.loginClient.cancelCurrentHandler();
        super.onDestroy();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View}
     arg types: [int, android.view.ViewGroup, int]
     candidates:
      ClspMth{android.view.LayoutInflater.inflate(org.xmlpull.v1.XmlPullParser, android.view.ViewGroup, boolean):android.view.View}
      ClspMth{android.view.LayoutInflater.inflate(int, android.view.ViewGroup, boolean):android.view.View} */
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(getLayoutResId(), viewGroup, false);
        final View findViewById = inflate.findViewById(R.id.com_facebook_login_fragment_progress_bar);
        this.loginClient.setBackgroundProcessingListener(new LoginClient.BackgroundProcessingListener() {
            /* class com.facebook.login.LoginFragment.AnonymousClass2 */

            public void onBackgroundProcessingStarted() {
                findViewById.setVisibility(0);
            }

            public void onBackgroundProcessingStopped() {
                findViewById.setVisibility(8);
            }
        });
        return inflate;
    }

    public void onLoginClientCompleted(LoginClient.Result result) {
        this.request = null;
        int i = result.code == LoginClient.Result.Code.CANCEL ? 0 : -1;
        Bundle bundle = new Bundle();
        bundle.putParcelable("com.facebook.LoginFragment:Result", result);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        if (isAdded()) {
            getActivity().setResult(i, intent);
            getActivity().finish();
        }
    }

    public void onResume() {
        super.onResume();
        if (this.callingPackage == null) {
            Log.e("LoginFragment", "Cannot call LoginFragment with a null calling package. This can occur if the launchMode of the caller is singleInstance.");
            getActivity().finish();
            return;
        }
        this.loginClient.startOrContinueAuth(this.request);
    }

    public void onPause() {
        View view;
        super.onPause();
        if (getView() == null) {
            view = null;
        } else {
            view = getView().findViewById(R.id.com_facebook_login_fragment_progress_bar);
        }
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.loginClient.onActivityResult(i, i2, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("loginClient", this.loginClient);
    }

    private void initializeCallingPackage(Activity activity) {
        ComponentName callingActivity = activity.getCallingActivity();
        if (callingActivity != null) {
            this.callingPackage = callingActivity.getPackageName();
        }
    }

    /* access modifiers changed from: package-private */
    public LoginClient getLoginClient() {
        return this.loginClient;
    }
}
